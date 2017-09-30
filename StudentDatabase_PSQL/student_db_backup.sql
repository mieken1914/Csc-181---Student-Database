--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: address; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE address AS (
	house_num integer,
	street character varying(10),
	brgy character varying(20),
	city character varying(15)
);


ALTER TYPE public.address OWNER TO postgres;

--
-- Name: fullname; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE fullname AS (
	f_name character varying(20),
	l_name character varying(20),
	m_name character varying(20)
);


ALTER TYPE public.fullname OWNER TO postgres;

--
-- Name: year_enum; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE year_enum AS ENUM (
    '1st Year',
    '2nd Year',
    '3rd Year',
    '4th Year',
    '5th Year',
    'Irregular Year'
);


ALTER TYPE public.year_enum OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: student; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE student (
    idnum integer NOT NULL,
    name fullname,
    gender character(1),
    college character varying(10),
    course character varying(20),
    year_lvl year_enum,
    address address,
    bdate date
);


ALTER TABLE public.student OWNER TO postgres;

--
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY student (idnum, name, gender, college, course, year_lvl, address, bdate) FROM stdin;
201248557	(As-Harrie,Dianalan,Domado)	M	CIT	BS - CS	3rd Year	(111,"Alauya St","Moncado Colony","Marawi City")	1995-01-14
201248001	(Apipah,Polao,Desso)	F	CNSM	Biology	4th Year	(111,Disomancop,Lancaf,Marawi)	1995-02-06
201248002	(Ashraf,Dianalan,Dianalan)	M	CNSM	BS-Physics	1st Year	(111,"Quezon St","Brgy Palao","Iligan City")	2005-06-30
\.


--
-- Name: student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY student
    ADD CONSTRAINT student_pkey PRIMARY KEY (idnum);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

