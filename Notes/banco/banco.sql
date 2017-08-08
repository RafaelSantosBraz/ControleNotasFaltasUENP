--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

-- Started on 2017-08-08 10:51:41

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2123 (class 1262 OID 16403)
-- Name: notes; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE notes WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE notes OWNER TO postgres;

\connect notes

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
-- TOC entry 2125 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 16404)
-- Name: Aluno; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Aluno" (
    "idAluno" integer NOT NULL,
    "cpfAluno" character(14) NOT NULL,
    "rgAluno" character(12) NOT NULL,
    "dataNascimentoAluno" date NOT NULL,
    "emailAluno" character(45) NOT NULL,
    "celularAluno" character(16),
    "raAluno" character(6) NOT NULL
);


ALTER TABLE "Aluno" OWNER TO postgres;

--
-- TOC entry 2118 (class 0 OID 16404)
-- Dependencies: 185
-- Data for Name: Aluno; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2000 (class 2606 OID 16408)
-- Name: Aluno Aluno_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Aluno"
    ADD CONSTRAINT "Aluno_pkey" PRIMARY KEY ("idAluno");


-- Completed on 2017-08-08 10:51:41

--
-- PostgreSQL database dump complete
--

