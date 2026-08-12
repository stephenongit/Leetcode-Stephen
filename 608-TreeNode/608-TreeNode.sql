-- Last updated: 12/08/2026, 19:11:05
SELECT
    id,
    CASE
        WHEN p_id IS NULL THEN 'Root'
        WHEN id IN (SELECT DISTINCT p_id FROM Tree WHERE p_id IS NOT NULL)
            THEN 'Inner'
        ELSE 'Leaf'
    END AS type
FROM Tree;