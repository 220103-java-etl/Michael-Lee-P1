/**
 * 
 * AJAX = Asynchronous JavaScript and XML
 * -describes the process of exchanging data from a web server 
 * asynchronously with the help of HTML and JavaScript (and XML but we are  going to be using JSON)
 * 
 * AJAX uses the Browser's built in XMLHttpRequest Object (xhr, xhttp)
 * -this object is used to send and receive data from a server asynchronously, in the background, 
 * without blocking or interfering with the user's expereince AND without reloading the page
 * 
 * AJAX Workflow
 * 1. A client  event occurs on a webpage
 * 2. JavaScript creates and XHR Object 
 * 3. The object makes an asynchronous request
 * 4. The server processes the request
 * 5. Creates a response and sends it back to the client 
 * 6. The client processes that response using JS
 * 7. JS updates the page
 * 
 */

function getData(){
    let url = 'https://jsonplaceholder.typicode.com/posts';
    //this is where we would want to get the number input by the user 
    //4 Step to making an AJAX call

    //1.Create our XHR Object
    let xhr = new XMLHttpRequest();

    //2. Set callback function for the ready-state-change event
    xhr.onreadystatechange = receiveData;

    //3. Open the request 
    xhr.open('GET',url, true) //true is default 

    function receiveData(){
        //This is where we would put our DOM manipulation 
        if (xhr.readyState== 4 && xhr.status == 200){
            let r = xhr.responseText;
            console.log(r);

            rJson = JSON.parse(r);
            console.log(rJson)
        }
    }
}