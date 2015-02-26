

jQuery(document).ready(function($) {

	var url = window.location.href;

	var query = gup('lang');

	if (query == null){
		$('#flag').addClass('langfr').removeClass('langen');
	}
	else if (query == "en"){
		$('#flag').addClass('langfr').removeClass('langen');
	}
	else if (query == "fr"){
		$('#flag').addClass('langen').removeClass('langfr');
	}

});




function gup( name )
{
	name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
	var regexS = "[\\?&]"+name+"=([^&#]*)";
	var regex = new RegExp( regexS );
	var results = regex.exec( window.location.href );
	if( results == null )
		return null;
	else
		return results[1];
}


function setGetParameter(paramName, paramValue)
{
	var url = window.location.href;

	if (url.indexOf("#") >= 0)
	{
			var suffix = paramName +"=" + paramValue
			var diese =  url.substring(url.indexOf('#'));
			url ="?" + suffix + diese;
	}
	else if (url.indexOf(paramName + "=") >= 0)
	{
		var prefix = url.substring(0, url.indexOf(paramName));
		var suffix = url.substring(url.indexOf(paramName));
		suffix = suffix.substring(suffix.indexOf("=") + 1);
		suffix = (suffix.indexOf("&") >= 0) ? suffix.substring(suffix.indexOf("&")) : "";
		url = prefix + paramName + "=" + paramValue + suffix;
	}
	else
	{
		if (url.indexOf("?") < 0)
			url += "?" + paramName + "=" + paramValue;
		else
			url += "&" + paramName + "=" + paramValue;
	}
	window.location.href = url;
}

function switchLang() {

	var url = window.location.href;
	var query = gup('lang');

	//par defaut
	if (query == null){
		setGetParameter("lang", "fr")
	}
	else if (query == "en"){
		setGetParameter("lang", "fr")

	}
	else if (query == "fr"){
		setGetParameter("lang", "en")

	}


};

