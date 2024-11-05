-- Tabla biker
CREATE TABLE IF NOT EXISTS biker (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    piun BIGINT UNIQUE NOT NULL,
    name VARCHAR(255),
    birthdate TIMESTAMP
);

CREATE UNIQUE INDEX IF NOT EXISTS biker_name_Idx ON biker(name);

-- Tabla biker_challenge
CREATE TABLE IF NOT EXISTS biker_challenge (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    biker_id BIGINT,
    challenge_id BIGINT,
    credit_number BIGINT,
    biker_challenge_status VARCHAR(10),
    creation_date TIMESTAMP
);

CREATE UNIQUE INDEX IF NOT EXISTS biker_idx ON biker_challenge(biker_id);
CREATE UNIQUE INDEX IF NOT EXISTS challenge_idx ON biker_challenge(challenge_id);

-- Tabla challenge
CREATE TABLE IF NOT EXISTS challenge (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    challenge_level VARCHAR(10),
    description VARCHAR(255)
);

-- Tabla payment
CREATE TABLE IF NOT EXISTS payment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    biker_id BIGINT,
    amount DOUBLE,
    payment_date TIMESTAMP,
    status VARCHAR(10) DEFAULT 'NC'
);

-- Tabla events
CREATE TABLE IF NOT EXISTS EVENT_PUBLICATION
(
  ID               UUID NOT NULL,
  COMPLETION_DATE  TIMESTAMP(9) WITH TIME ZONE,
  EVENT_TYPE       VARCHAR(512) NOT NULL,
  LISTENER_ID      VARCHAR(512) NOT NULL,
  PUBLICATION_DATE TIMESTAMP(9) WITH TIME ZONE NOT NULL,
  SERIALIZED_EVENT VARCHAR(4000) NOT NULL,
  PRIMARY KEY (ID)
);