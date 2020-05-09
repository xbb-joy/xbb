//瀵艰埅閫夋嫨鍣�var url = window.location.href;
if (url.indexOf("newsCategoryManage") > 0
		|| url.indexOf("newsCategoryEdit") > 0) {
	$("#news").addClass("active");
	$("#newsCategoryManage").addClass("active");
} else if (url.indexOf("newsManage") > 0 || url.indexOf("newsEdit") > 0) {
	$("#news").addClass("active");
	$("#newsManage").addClass("active");
}

// 鎻愮ず鏉￠厤缃�toastr.options = {
	"closeButton" : true,
	"debug" : false,
	"progressBar" : true,
	"preventDuplicates" : false,
	"positionClass" : "toast-top-right",
	"onclick" : null,
	"showDuration" : "400",
	"hideDuration" : "1000",
	"timeOut" : "7000",
	"extendedTimeOut" : "1000",
	"showEasing" : "swing",
	"hideEasing" : "linear",
	"showMethod" : "fadeIn",
	"hideMethod" : "fadeOut"
}