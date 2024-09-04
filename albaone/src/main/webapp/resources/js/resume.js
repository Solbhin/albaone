/// 파일 확장자 유효성 검사
function validateFile() {
    var fileInput = document.querySelector('input[name="myimg"]');
    var filePath = fileInput.value;
    var allowedExtensions = /(\.png|\.jpg|\.jpeg)$/i;

    if (!allowedExtensions.exec(filePath)) {
        alert('유효한 이미지 파일만 업로드할 수 있습니다. (png, jpg, jpeg)');
        fileInput.value = '';
        return false;
    }
    return true;
}

// 학력사항 추가
function addEducationField() {
    var container = document.getElementById('educationFields');
    var newField = document.createElement('div');
    newField.className = 'mb-3';
    newField.innerHTML = `
        <input type="text" class="form-control" name="school[]" placeholder="학교명" required>
        <input type="text" class="form-control mt-2" name="period[]" placeholder="기간" required>
        <input type="text" class="form-control mt-2" name="major[]" placeholder="전공" required>
    `;
    container.appendChild(newField);
}

// 경력사항 추가
function addExperienceField() {
    var container = document.getElementById('experienceFields');
    var newField = document.createElement('div');
    newField.className = 'mb-3';
    newField.innerHTML = `
        <input type="text" class="form-control" name="job_title[]" placeholder="직장명" required>
        <input type="text" class="form-control mt-2" name="experience_period[]" placeholder="기간" required>
        <input type="text" class="form-control mt-2" name="main_work[]" placeholder="주요 업무" required>
    `;
    container.appendChild(newField);
}