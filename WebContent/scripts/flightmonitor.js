  $(document).ready(function($){
	$("#inputDateI").mask('00/00/0000 00:00:00');
	$("#inputDateF").mask('00/00/0000 00:00:00');
	
	$("#btnConsulta").click(function(){ 
		$("#loading").css("display", "");
	 });
	
	$("#myform").on("submit",function(){
		$("#loading").css("display", "");
		$("#btnConsulta").prop("disabled", true);
		console.log("aaaa");
	});
		
	});
	
 
  
  let map;

  function initMap() {
    map = new google.maps.Map(document.getElementById("map"), {
      center: { lat: -23.4319, lng: -46.4694 },
      zoom: 8,
    });
  }
  
