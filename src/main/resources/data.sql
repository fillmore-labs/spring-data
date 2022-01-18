INSERT INTO PERSON (ID, GIVEN_NAME, SURNAME)
VALUES (101, 'Peter', 'Pan'),
       (102, 'Wendy', 'Darling'),
       (103, 'John', 'Darling'),
       (104, 'Michael', 'Darling'),
       (105, 'Nana', null);

INSERT INTO EMAIL_ADDRESS (PERSON_ID, ADDRESS)
VALUES (101, 'peter.pan@example.com'),
       (101, 'peter.pan@example.org'),
       (102, 'wendy.darling@example.com'),
       (102, 'wendy.darling@example.org'),
       (103, 'john.darling@example.com'),
       (104, 'michael.darling@example.com');
