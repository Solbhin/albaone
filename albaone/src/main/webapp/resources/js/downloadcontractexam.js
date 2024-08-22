function downloadPDF()
{
	var element = document.getElementById('contract'); // PDF로 변환할 요소

	html2canvas(element).then(function (canvas)
	{
		var imgData = canvas.toDataURL('image/png');
		var pdf = new jsPDF();
		var imgWidth = 190; // PDF에 맞게 이미지 너비 조정
		var pageHeight = pdf.internal.pageSize.height;
		var imgHeight = (canvas.height * imgWidth) / canvas.width;
		var heightLeft = imgHeight;
		var position = 0;
	
		// 페이지가 넘어가는 경우 처리
		pdf.addImage(imgData, 'PNG', 10, position, imgWidth, imgHeight);
		heightLeft -= pageHeight;

		while (heightLeft >= 0)
		{
			position = heightLeft - imgHeight;
			pdf.addPage();
			pdf.addImage(imgData, 'PNG', 10, position, imgWidth, imgHeight);
			heightLeft -= pageHeight;
		}
		pdf.save('contract.pdf'); // PDF 파일 이름 설정
	});
}