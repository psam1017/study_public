
# GRUOP BY, HAVING 사용하기 / 그룹 통계 구하기.
SELECT	반.grade_value 학년,
		반.value 반,
        ROUND(AVG(점수.score), 2) `평균 점수`
FROM study_school.classes 반
LEFT JOIN study_school.scores 점수
	ON 반.grade_value = 점수.student_grade
    AND 반.value = 점수.student_class
GROUP BY 반.grade_value, 반.value
ORDER BY `평균 점수` DESC;



SELECT	CONCAT(학생.grade_value, "학년 ", 학생.class_value, "반 ", 학생.number, "번") `학반번호`,
		학생.name `학생 이름`,
        AVG(점수.score) `평균 점수`,
        담임.teacher_id `교번`,
        교사.name `담임 이름`,
        RANK() OVER (ORDER BY `평균 점수` DESC) `반 석차`
FROM study_school.students 학생
LEFT JOIN study_school.scores 점수
	ON 학생.grade_value = 점수.student_grade
    AND 학생.class_value = 점수.student_class
    AND 학생.number = 점수.student_number
LEFT JOIN study_school.designations 담임
	ON 학생.grade_value = 담임.grade_value
    AND 학생.class_value = 담임.class_value
LEFT JOIN study_school.teachers 교사
	ON 담임.teacher_id = 교사.id
GROUP BY 학생.grade_value, 학생.class_value, 학생.number
ORDER BY `학반번호` ASC;
