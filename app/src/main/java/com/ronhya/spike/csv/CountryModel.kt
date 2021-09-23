package com.ronhya.spike.csv

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder("Country", "Capital")
data class CountryModel(
    @field:JsonProperty("Country")
    val country: String,
    @field:JsonProperty("Capital")
    val capital: String,
    val currency: String
)
