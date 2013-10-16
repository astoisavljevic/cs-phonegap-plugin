var app = {
    // Application Constructor
    initialize: function() {
        this.bindEvents();
    },
    // Bind Event Listeners
    //
    // Bind any events that are required on startup. Common events are:
    // 'load', 'deviceready', 'offline', and 'online'.
    bindEvents: function() {
        document.addEventListener('deviceready', this.onDeviceReady, false);
    },
    // deviceready Event Handler
    //
    onDeviceReady: function() {        
		console.log('onDeviceReady');
		
		window.echo("simple", function(echoValue) {
        	// alert('macAddress: ' + echoValue); // should alert true.
        	document.getElementById("macAddress").innerHTML = "MAC address: " + echoValue;
    	});	
		
    }
};

