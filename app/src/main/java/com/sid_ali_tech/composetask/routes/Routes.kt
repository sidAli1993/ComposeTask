package com.sid_ali_tech.composetask.routes

const val userNameKey="userName"
sealed class Routes(val route:String) {


    object LoginPage: Routes("LoginPage")

    object DashboardScreen:Routes("DashboardScreen/{$userNameKey}"){
        fun getParams(userName:String):String{
            return "DashboardScreen/$userName"
        }
    }
}