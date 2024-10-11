function calcAverageHumanAge(ages) {
    const humanAges = ages.map(age => {
        if (age <= 2) {
            return age * 2;
        } else {
            return 16 + age * 4;
        }
    });
    const adults = humanAges.filter(humanAge => humanAge >= 18);

    const averageAge = adults.reduce((acc, age) => acc + age, 0) / adults.length;
    return averageAge;
}
const data1 = [5, 2, 4, 1, 15, 8, 3];
const data2 = [16, 6, 10, 5, 6, 1, 4];
console.log('Tuổi trung bình của người cho dữ liệu 1:', calcAverageHumanAge(data1));
console.log('Tuổi trung bình của người cho dữ liệu 2:', calcAverageHumanAge(data2));
