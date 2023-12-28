// JavaScript Document
function g(o){
return document.getElementById('l'+o);}
function f(i){
return document.getElementById('Setl'+i);}
function setTab(x){ 
for(i=1;i<=4;i++)
{
  g(i).className="selectTab1";
  f(i).style.display="none";
}
g(x).className="selectTab2";
f(x).style.display="block";
}

function m(o){
return document.getElementById('lm'+o);}
function n(i){
return document.getElementById('Setln'+i);}
function setTabb(x){ 
for(i=1;i<=2;i++)
{
  m(i).className="selectTab3";
  n(i).style.display="none";
}
m(x).className="selectTab4";
n(x).style.display="block";
}

