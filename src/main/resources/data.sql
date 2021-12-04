INSERT INTO PERSON (ID, GIVEN_NAME, SURNAME)
VALUES (1, 'Peter', 'Pan'),
       (2, 'Wendy', 'Darling'),
       (3, 'John', 'Darling'),
       (4, 'Michael', 'Darling'),
       (5, 'Nana', null);

INSERT INTO EMAIL_ADDRESS (PERSON_ID, ADDRESS)
VALUES (1, 'peter.pan@example.com'),
       (1, 'peter.pan@example.org'),
       (2, 'wendy.darling@example.com'),
       (2, 'wendy.darling@example.org'),
       (3, 'john.darling@example.com'),
       (4, 'michael.darling@example.com');
