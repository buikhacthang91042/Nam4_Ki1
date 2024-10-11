function checkDogs(dogsJulia, dogsKate) {
    const banSaoNongcuaJulia = dogsJulia.slice();
    banSaoNongcuaJulia.splice(0,2);
    banSaoNongcuaJulia.splice(-2);

    const allDogs = banSaoNongcuaJulia.concat(dogsKate);

    allDogs.forEach((age,index) => {
        if(age >=3){
            console.log(`Con chó số ${index + 1} là một con chó trưởng thành và ${age} tuổi`);
        } else {
            console.log(`Con chó số ${index + 1} vẫn là một con chó con`);
        }
    });
}
const juliaData1 = [3, 5, 2, 12, 7];
const kateData1 = [4, 1, 15, 8, 3];
const juliaData2 = [9, 16, 6, 8, 3];
const kateData2 = [10, 5, 6, 1, 4];
console.log('Dữ liệu kiểm tra 1:');
checkDogs(juliaData1, kateData1);
console.log('Dữ liệu kiểm tra 2:');
checkDogs(juliaData2, kateData2);