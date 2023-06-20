CREATE TABLE IF NOT EXISTS public.birds
(
    id integer NOT NULL DEFAULT nextval('birds_id_seq'::regclass),
    bird character varying(256) COLLATE pg_catalog."default",
    description character varying(1024) COLLATE pg_catalog."default",
    CONSTRAINT birds_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.birds
    OWNER to postgres;

CREATE TABLE birds (
                       id SERIAL PRIMARY KEY,
                       bird VARCHAR(256),
                       description VARCHAR(1024)
);

INSERT INTO birds (bird , description) VALUES
                                           ('pigeon', 'common in cities'),
                                           ('eagle', 'bird of prey');