-- Last updated: 12/08/2026, 19:08:17
SELECT
    player_id,
    MIN(event_date) AS first_login
FROM Activity
GROUP BY player_id;