//HTML Parser
//Parses html string type to dom obj
function stringParser(htmlString) {

    var parser = new DOMParser();
    htmlString = htmlString.responseText;

    htmlString = parser.parseFromString(htmlString, "text/html");

    return htmlString;
}