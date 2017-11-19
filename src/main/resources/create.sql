CREATE OR REPLACE FUNCTION update_modified_column()
  RETURNS TRIGGER AS $$
BEGIN
  IF row(NEW.*) IS DISTINCT FROM row(OLD.*) THEN
    NEW.modified = now();
    RETURN NEW;
  ELSE
    RETURN OLD;
  END IF;
END;
$$ language 'plpgsql';

CREATE TABLE activities(
  id INTEGER NOT NULL PRIMARY KEY,
  label CHARACTER VARYING NOT NULL
);

CREATE TABLE time_entries (
  id SERIAL PRIMARY KEY,
  created TIMESTAMP WITHOUT TIME ZONE DEFAULT now(),
  activity_id INT NOT NULL REFERENCES activities(id),

  comment CHARACTER VARYING(1000),
  started TIMESTAMP NOT NULL,
  ended TIMESTAMP
);

insert into activities (id, label)  values(1, 'family'), (2, 'friends'), (3,'work'), (4, 'travel'),  (5, 'commuting'), (6, 'internet'), (7, 'side projects');

