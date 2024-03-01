package com.cankuloglu.kotlinretrofit.service

import com.cankuloglu.kotlinretrofit.model.CryptoModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    //GET, POST, UPDATE, DELETE

    //https://raw.githubusercontent.com/
    //atilsamancioglu/K21-JSONDataSet/master/crypto.json

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData(): Observable<List<CryptoModel>>
}