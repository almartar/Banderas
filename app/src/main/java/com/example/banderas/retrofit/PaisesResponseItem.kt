package com.example.banderas.retrofit

data class PaisesResponseItem(

    val flags: FlagModel,
    val name: NameModel,
    val languages: LanguagesModel

)

data class FlagModel(

    val png: String,
    val svg: String,
    val alt: String
)

data class NameModel(

    val common: String,
    val official: String,
    val nativeName: NativeNameModel
)

data class NativeNameModel(

    val cat: CatModel


)

data class CatModel(

    val official: String,
    val common: String
)

data class LanguagesModel(

    val cat: String
)






