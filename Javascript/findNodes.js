//find values inside each element from a HTML obj its siblings
//Recursive to join values splited in several tags
function findNodes(node, childValues, nodeSize, i) {

    var nodeType;
    var dec;

    for (i = 0; i < nodeSize; ++i) {
        nodeType = node.nodeType;
        if (nodeType !== 3 && node[i].hasChildNodes()) {
            dec = decodeURIComponent(node[i].innerText);
            if (typeof node[i] !== 'undefined' && dec !== " ") {
                childValues.push(node[i].innerText);
                findNodes(node[i].nextSibling, childValues, i);
            }
        }
    }
    return childValues;
}
