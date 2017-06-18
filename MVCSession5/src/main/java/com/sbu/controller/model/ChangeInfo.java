/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbu.controller.model;

/**
 *
 * @author reyhaneh
 */
public class ChangeInfo 
{
    private String email;
    private String pass;
    private String repeatPass;
    
    public void setEmail (String email)
    {
        this.email = email;
    }
    
    public void setPass (String pass)
    {
        this.pass = pass;
    }
    
    public void setRepeatPass (String repeatPass)
    {
        this.repeatPass = repeatPass;
    }
    
    public String getEmail ()
    {
        return email;
    }
    
    public String getPass()
    {
        return pass;
    }
    
    public String getRepeatPass ()
    {
        return repeatPass;
    }
}