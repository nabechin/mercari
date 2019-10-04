$(function() {
	$(".category-select").on("change", function() {
		$("#form [name=action]").val('category');
		$("#form").submit();
	});
});