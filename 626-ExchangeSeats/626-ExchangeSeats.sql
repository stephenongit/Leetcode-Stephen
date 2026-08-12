-- Last updated: 12/08/2026, 19:10:52
SELECT
    CASE
        WHEN MOD(id, 2) = 1 AND id = (SELECT MAX(id) FROM Seat)
            THEN id
        WHEN MOD(id, 2) = 1
            THEN id + 1
        ELSE id - 1
    END AS id,
    student
FROM Seat
ORDER BY id;