
WITH user_count AS (
    SELECT COUNT(*) AS count FROM users
)
INSERT INTO users (created_date, is_deleted, name, surname,username, email_address, password, about_me, detail)
SELECT current_timestamp, 0, 'deniz', 'kırıtoğlu','dnz', 'deniz@gmail.com', '1234', 'mememe', 'meeeee'
WHERE (SELECT count FROM user_count) = 0;


WITH level_count AS (
    SELECT COUNT(*) AS count FROM language_levels
)
INSERT INTO language_levels (is_deleted, created_date, name, level)
SELECT 0, current_timestamp, 'A1', 1
WHERE (SELECT count FROM level_count) = 0
UNION ALL
SELECT 0, current_timestamp, 'A2', 2
WHERE (SELECT count FROM level_count) = 0
UNION ALL
SELECT 0, current_timestamp, 'B1', 3
WHERE (SELECT count FROM level_count) = 0
UNION ALL
SELECT 0, current_timestamp, 'B2', 4
WHERE (SELECT count FROM level_count) = 0
UNION ALL
SELECT 0, current_timestamp, 'C1', 5
WHERE (SELECT count FROM level_count) = 0
UNION ALL
SELECT 0, current_timestamp, 'C2', 6
WHERE (SELECT count FROM level_count) = 0;


INSERT INTO languages (is_deleted, created_date, name, level_id)
SELECT 0, current_timestamp, 'English', id
FROM language_levels
WHERE name = 'B2'
AND NOT EXISTS (SELECT 1 FROM languages);


