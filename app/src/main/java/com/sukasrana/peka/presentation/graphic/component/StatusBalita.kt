package com.sukasrana.peka.presentation.graphic.component

fun StatusBalita(
    years: Int,
    months: Int,
    weight: Int
): String{
    val month = 12*years+months
    var status:String = "out"

    when{
        month == 0 ->
            when{
                weight < 2.5 -> status = "kurang"
                2.5 <= weight && weight <= 4.5 -> status = "sedang"
                weight > 4.5 -> status = "lebih"
            }
        month == 1 ->
            when{
                weight < 3.5 -> status = "kurang"
                3.5 <= weight && weight <= 6 -> status = "sedang"
                weight > 6 -> status = "lebih"
            }
        month == 2 ->
            when{
                weight < 4.5 -> status = "kurang"
                4.5 <= weight && weight <= 7 -> status = "sedang"
                weight > 7 -> status = "lebih"
            }
        month == 3 ->
            when{
                weight < 4.5 -> status = "kurang"
                4.5 <= weight && weight <= 7 -> status = "sedang"
                weight > 7 -> status = "lebih"
            }
        month == 4 ->
            when{
                weight < 5.5 -> status = "kurang"
                5.5 <= weight && weight <= 8.5 -> status = "sedang"
                weight > 8.5 -> status = "lebih"
            }
        month == 5 ->
            when{
                weight < 6 -> status = "kurang"
                6 <= weight && weight <= 9.5 -> status = "sedang"
                weight > 9.5 -> status = "lebih"
            }
        month == 6 ->
            when{
                weight < 6.5 -> status = "kurang"
                6.5 <= weight && weight <= 10 -> status = "sedang"
                weight > 10 -> status = "lebih"
            }
        month == 7 ->
            when{
                weight < 6.5 -> status = "kurang"
                6.5 <= weight && weight <= 10.25 -> status = "sedang"
                weight > 10.5 -> status = "lebih"
            }
        month == 8 ->
            when{
                weight < 7 -> status = "kurang"
                7 <= weight && weight <= 10.5 -> status = "sedang"
                weight > 10.5 -> status = "lebih"
            }
        month == 9 ->
            when{
                weight < 7.2 -> status = "kurang"
                7.2 <= weight && weight <= 11 -> status = "sedang"
                weight > 11 -> status = "lebih"
            }
        month == 10 ->
            when{
                weight < 7.3 -> status = "kurang"
                7.3 <= weight && weight <= 11.4 -> status = "sedang"
                weight > 11.4 -> status = "lebih"
            }
        month == 11 ->
            when{
                weight < 7.5 -> status = "kurang"
                7.5 <= weight && weight <= 11.8 -> status = "sedang"
                weight > 11.8 -> status = "lebih"
            }
        month == 12 ->
            when{
                weight < 7.8 -> status = "kurang"
                7.8 <= weight && weight <= 12 -> status = "sedang"
                weight > 12 -> status = "lebih"
            }
        month == 13 ->
            when{
                weight < 8 -> status = "kurang"
                8 <= weight && weight <= 12.3 -> status = "sedang"
                weight > 12.3 -> status = "lebih"
            }
        month == 14 ->
            when{
                weight < 8.1 -> status = "kurang"
                8.1 <= weight && weight <= 12.6 -> status = "sedang"
                weight > 12.6 -> status = "lebih"
            }
        month == 15 ->
            when{
                weight < 8.3 -> status = "kurang"
                8.3 <= weight && weight <= 12.9 -> status = "sedang"
                weight > 12.9 -> status = "lebih"
            }
        month == 16 ->
            when{
                weight <8.4 -> status = "kurang"
                8.4 <= weight && weight <= 13.1 -> status = "sedang"
                weight > 13.1 -> status = "lebih"
            }
        month == 17 ->
            when{
                weight < 8.6 -> status = "kurang"
                8.6 <= weight && weight <= 13.4 -> status = "sedang"
                weight > 13.4 -> status = "lebih"
            }
        month == 18 ->
            when{
                weight < 8.8 -> status = "kurang"
                8.8 <= weight && weight <= 13.6 -> status = "sedang"
                weight > 13.6 -> status = "lebih"
            }
        month == 19 ->
            when{
                weight < 8.9 -> status = "kurang"
                8.9 <= weight && weight <= 13.9 -> status = "sedang"
                weight > 13.9 -> status = "lebih"
            }
        month == 20 ->
            when{
                weight < 9.1 -> status = "kurang"
                9.1 <= weight && weight <= 14.2 -> status = "sedang"
                weight > 14.2 -> status = "lebih"
            }
        month == 21 ->
            when{
                weight < 9.2 -> status = "kurang"
                9.2 <= weight && weight <= 14.4 -> status = "sedang"
                weight > 14.4 -> status = "lebih"
            }
        month == 22 ->
            when{
                weight < 9.4 -> status = "kurang"
                9.4 <= weight && weight <= 14.8 -> status = "sedang"
                weight > 14.8 -> status = "lebih"
            }
        month == 23 ->
            when{
                weight < 9.6 -> status = "kurang"
                9.6 <= weight && weight <= 15 -> status = "sedang"
                weight > 15 -> status = "lebih"
            }
        month == 24 ->
            when{
                weight < 9.7 -> status = "kurang"
                9.7 <= weight && weight <= 15.3 -> status = "sedang"
                weight > 15.2 -> status = "lebih"
            }
        else -> status = "out"
    }
    return status
}