--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

-- Started on 2017-08-01 09:30:40

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2129 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 16397)
-- Name: curso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE curso (
    codigo integer NOT NULL,
    nome character varying(50)
);


ALTER TABLE curso OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16395)
-- Name: curso_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE curso_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE curso_codigo_seq OWNER TO postgres;

--
-- TOC entry 2130 (class 0 OID 0)
-- Dependencies: 185
-- Name: curso_codigo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE curso_codigo_seq OWNED BY curso.codigo;


--
-- TOC entry 2001 (class 2604 OID 16400)
-- Name: curso codigo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY curso ALTER COLUMN codigo SET DEFAULT nextval('curso_codigo_seq'::regclass);


--
-- TOC entry 2122 (class 0 OID 16397)
-- Dependencies: 186
-- Data for Name: curso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY curso (codigo, nome) FROM stdin;
1	Programação de Aeronaves
2	Programação de Aeronaves
\.


--
-- TOC entry 2131 (class 0 OID 0)
-- Dependencies: 185
-- Name: curso_codigo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('curso_codigo_seq', 2, true);


--
-- TOC entry 2003 (class 2606 OID 16402)
-- Name: curso curso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY curso
    ADD CONSTRAINT curso_pkey PRIMARY KEY (codigo);


-- Completed on 2017-08-01 09:30:40

--
-- PostgreSQL database dump complete
--

