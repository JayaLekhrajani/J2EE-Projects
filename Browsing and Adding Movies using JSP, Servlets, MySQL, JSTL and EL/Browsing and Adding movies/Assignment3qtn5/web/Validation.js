/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validateForm1()
{
    
    
    var num=document.getElementById("check");
    alert("Entering the function");
    if(num.value=="" ||num.value<=0 || (!num.value.match(/^\d*$/)))
    {
       alert("Enter a valid number"); 
   
        
    }
    
    else
    {
        
        
    }
    
    
    
}
