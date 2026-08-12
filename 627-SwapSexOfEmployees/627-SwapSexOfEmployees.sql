-- Last updated: 12/08/2026, 19:10:47
UPDATE Salary
SET sex = CASE
    WHEN sex = 'm' THEN 'f'
    ELSE 'm'
END;