-- Last updated: 12/08/2026, 19:11:14
WITH cte AS (
    SELECT
        id,
        visit_date,
        people,
        id - ROW_NUMBER() OVER (ORDER BY id) grp
    FROM Stadium
    WHERE people >= 100
)
SELECT
    s.id,
    s.visit_date,
    s.people
FROM cte s
JOIN (
    SELECT grp
    FROM cte
    GROUP BY grp
    HAVING COUNT(*) >= 3
) g
ON s.grp = g.grp
ORDER BY s.visit_date;