--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

-- Started on 2017-11-11 23:56:39

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2105 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 16460)
-- Name: transactions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE transactions (
    id integer NOT NULL,
    sum numeric(18,2),
    description character varying(100),
    date date
);


ALTER TABLE transactions OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16458)
-- Name: transactions_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE transactions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE transactions_id_seq OWNER TO postgres;

--
-- TOC entry 2106 (class 0 OID 0)
-- Dependencies: 181
-- Name: transactions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE transactions_id_seq OWNED BY transactions.id;


--
-- TOC entry 1981 (class 2604 OID 16463)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY transactions ALTER COLUMN id SET DEFAULT nextval('transactions_id_seq'::regclass);


--
-- TOC entry 1983 (class 2606 OID 16465)
-- Name: pk_transactions; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY transactions
    ADD CONSTRAINT pk_transactions PRIMARY KEY (id);


--
-- TOC entry 2104 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-11-11 23:56:40

--
-- PostgreSQL database dump complete
--

