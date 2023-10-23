select *
from department;

-- -----------------------------------------------------------------------------------------------
-- QUESTION TWO SBA
SELECT department.name, COUNT(course.id) AS num_courses
FROM department
INNER JOIN course ON department.id = course.deptid
GROUP BY department.name
ORDER BY num_courses ASC, department.name desc;

-- both answers work
SELECT D.NAME AS Department, COUNT(C.ID) AS Number_of_Courses
FROM department D
LEFT JOIN course C ON D.ID = C.DEPTID
GROUP BY D.NAME
ORDER BY Number_of_Courses ASC, Department ASC;


-- -----------------------------------------------------------------------------------------------
-- QUESTION THREE SBA
SELECT course.name, COUNT(studentCourse.studentId) AS num_students
FROM course
JOIN studentCourse ON course.id = studentCourse.courseId
GROUP BY course.name
ORDER BY num_students DESC, course.name ASC;


-- -----------------------------------------------------------------------------------------------
-- QUESTION FOUR SBA 
SELECT course.name
FROM course
LEFT JOIN facultyCourse ON course.id = facultyCourse.courseId
WHERE facultyCourse.facultyId IS NULL
ORDER BY course.name ASC;

-- -----------------------------------------------------------------------------------------------
-- QUESTION FIVE SBA

SELECT c.name AS Course_Name, COUNT(sc.studentId) AS num_students
FROM course c
LEFT JOIN studentcourse sc ON c.id = sc.courseId
WHERE c.id NOT IN (SELECT courseId FROM facultycourse)
GROUP BY c.name
ORDER BY num_students DESC, Course_Name ASC;
-- -----------------------------------------------------------------------------------------------
-- QUESTION SIX SBA
SELECT
    COUNT(DISTINCT sc.STUDENTID) AS students,
    EXTRACT(YEAR FROM sc.STARTDATE) AS year
FROM studentcourse sc
GROUP BY year
ORDER BY year ASC, students DESC;
-- -----------------------------------------------------------------------------------------------
-- QUESTION SEVEN SBA
SELECT
    STARTDATE AS start_date,
    COUNT(DISTINCT STUDENTID) AS num_students
FROM studentcourse
WHERE EXTRACT(MONTH FROM STARTDATE) = 8
GROUP BY start_date
ORDER BY start_date ASC, num_students ASC;

-- -----------------------------------------------------------------------------------------------
-- QUESTION EIGHT

select s.firstname, s.lastname , count(sc.courseId)
from student s , department d, studentcourse sc, course c
where s.majorId = d.id
and c.deptId = d.id
and c.id = sc.courseId
and sc.studentId = s.id
group by sc.studentId
order by 3 desc, 1 asc, 2 asc;

-- question eight-------
-- students are required to take 4 courses, and at least two of these courses 
-- must be from the department of their major
-- write a query to list students'firstname,lastname and number of courses they are
-- taking in their major department.
-- the output should be sorted first by the number of courses in descending order, then
-- by first name in ascending order, then by the last name in ascending order.

-- -----------------------------------------------------------------------------------------------
 -- QUESTION NINE 
 SELECT s.FIRSTNAME, s.LASTNAME,
       ROUND(AVG(sc.PROGRESS), 1) AS average_progress
FROM STUDENT s
JOIN STUDENTCOURSE sc ON s.ID = sc.STUDENTID
GROUP BY s.FIRSTNAME, s.LASTNAME
HAVING average_progress < 50
ORDER BY average_progress DESC, s.FIRSTNAME ASC, s.LASTNAME ASC;
-- -----------------------------------------------------------------------------------------------
-- BELOW IS BARD CODE BUT  DOESNT RUN IN HACKERANK 
SELECT s.FIRSTNAME, s.LASTNAME, ROUND(AVG(sc.PROGRESS), 1) AS AVG_PROGRESS
FROM STUDENT s
LEFT JOIN STUDENTCOURSE sc ON s.ID = sc.STUDENTID
LEFT JOIN COURSE c ON sc.COURSEID = c.ID
WHERE c.DEPTID = s.MAJORID
GROUP BY s.FIRSTNAME, s.LASTNAME
HAVING AVG_PROGRESS < 50
ORDER BY AVG_PROGRESS DESC, s.FIRSTNAME ASC, s.LASTNAME ASC;
-- -----------------------------------------------------------------------------------------------
-- QUESTION TEN
SELECT c.NAME AS course_name,
       ROUND(AVG(sc.PROGRESS), 1) AS average_progress
FROM COURSE c
LEFT JOIN STUDENTCOURSE sc ON c.ID = sc.COURSEID
GROUP BY c.NAME
ORDER BY average_progress DESC, c.NAME ASC;
-- -----------------------------------------------------------------------------------------------
-- QUESTION ELEVEN
SELECT c.NAME AS course_name,
       ROUND(MAX(average_progress), 1) AS highest_average_progress
FROM COURSE c
LEFT JOIN (
    SELECT COURSEID, AVG(PROGRESS) AS average_progress
    FROM STUDENTCOURSE
    GROUP BY COURSEID
) AS course_avg ON c.ID = course_avg.COURSEID
GROUP BY c.NAME
ORDER BY highest_average_progress DESC
LIMIT 1;
-- -----------------------------------------------------------------------------------------------
-- QUESTION TWELVE
SELECT f.FIRSTNAME, f.LASTNAME,
       ROUND(AVG(sc.PROGRESS), 1) AS average_progress
FROM FACULTY f
LEFT JOIN FACULTYCOURSE fc ON f.ID = fc.FACULTYID
LEFT JOIN STUDENTCOURSE sc ON fc.COURSEID = sc.COURSEID
GROUP BY f.FIRSTNAME, f.LASTNAME
ORDER BY average_progress DESC, f.FIRSTNAME ASC, f.LASTNAME ASC;
-- -----------------------------------------------------------------------------------------------
-- QUESTION THIRTEEN
 SELECT
    s.FIRSTNAME,
    s.LASTNAME,
    CASE
        WHEN MIN(sc.PROGRESS) < 40 THEN 'F'
        WHEN MIN(sc.PROGRESS) < 50 THEN 'D'
        WHEN MIN(sc.PROGRESS) < 60 THEN 'C'
        WHEN MIN(sc.PROGRESS) < 70 THEN 'B'
        ELSE 'A'
    END AS minimum_grade,
    CASE
        WHEN MAX(sc.PROGRESS) < 40 THEN 'F'
        WHEN MAX(sc.PROGRESS) < 50 THEN 'D'
        WHEN MAX(sc.PROGRESS) < 60 THEN 'C'
        WHEN MAX(sc.PROGRESS) < 70 THEN 'B'
        ELSE 'A'
    END AS maximum_grade
FROM
    STUDENT s
LEFT JOIN
    STUDENTCOURSE sc ON s.ID = sc.STUDENTID
GROUP BY
    s.FIRSTNAME, s.LASTNAME
ORDER BY
    minimum_grade DESC, maximum_grade DESC, s.FIRSTNAME ASC, s.LASTNAME ASC;
-- -----------------------------------------------------------------------------------------------

