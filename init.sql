-- init.sql
CREATE DATABASE IF NOT EXISTS personal_website_db;
USE personal_website_db;

CREATE TABLE IF NOT EXISTS blogs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    blog_category VARCHAR(255) NOT NULL UNIQUE,
    blog_title VARCHAR(255) NOT NULL
    blog_summary VARCHAR(255) NOT NULL
    blog_content VARCHAR(255) NOT NULL
    blog_last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    blog_create_date DATE DEFAULT CURRENT_DATE
);

INSERT INTO blogs (blog_category, blog_title, blog_summary, blog_content)
VALUES ('Sports',
'FORMULA 1 QATAR AIRWAYS AZERBAIJAN GRAND PRIX 2025 - RACE RESULT',
 'Qualifying in Baku had crashes, mayhem, a sprinkling of rain and a record number of red flags, and through it all serenely floated Max Verstappen to take a 46th pole position and a sixth of 2025.',
 'Behind him… chaos. Both McLarens hit the wall, as did Charles Leclerc, giving the grid a decidedly unfamiliar lookl Carlos Sainz lines up on the front row for the first time in Williams colours, just ahead of Liam Lawson in P3. Lando Norris is down in P7, but he does, at least, have the glass-half-full satisfaction of starting ahead of his championship rival – and for him, Oscar Piastri and Leclerc and the rest, there are some intriguing strategy options for race day…';