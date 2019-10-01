$(function() {
	$("#parent").on("change", function() {
		$("#form").submit();
	});
	$("#childParent").on("change", function() {
		$("#form").submit();
	});
});