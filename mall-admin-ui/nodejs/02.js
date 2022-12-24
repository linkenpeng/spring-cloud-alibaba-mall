const http = require('http');
http.createServer(function(request, response) {
    response.writeHead(200, {'Content-type':'text/html'});
    response.end('<h1>hello nodeJs Server</h1>')

}).listen(8888);
console.log("server running at: http://127.0.0.1:8888/");

