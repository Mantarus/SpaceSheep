/**
 * Created by iistomin on 18/03/17.
 */
var result = [];

var moveLeft = function() {
    result.push("MOVE LEFT");
};
var moveRight = function() {
    result.push("MOVE RIGHT");
};
var jumpLeft = function() {
    result.push("JUMP LEFT");
};
var jumpRight = function() {
    result.push("JUMP RIGHT");
};
var returnRes = function() {
    print(result);
};