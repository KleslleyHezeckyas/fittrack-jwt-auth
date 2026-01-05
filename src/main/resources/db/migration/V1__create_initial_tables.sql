CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE workout_session (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    capacity INTEGER NOT NULL,
    instructor_id BIGINT,
    CONSTRAINT fk_instructor FOREIGN KEY (instructor_id) REFERENCES users(id)
);

CREATE TABLE bookings (
    id BIGSERIAL PRIMARY KEY,
    student_id BIGINT NOT NULL,
    session_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES users(id),
    CONSTRAINT fk_session FOREIGN KEY (session_id) REFERENCES workout_session(id)
);