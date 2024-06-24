package com.sukasrana.peka.presentation.graphic.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.sukasrana.peka.data.ListData.DataBerat
import com.sukasrana.peka.data.ListData.DataTinggi
import com.sukasrana.peka.data.repository.fetchDataBaliatById
import com.sukasrana.peka.model.DataBalita
import com.sukasrana.peka.ui.theme.PekaTheme

@Composable
fun TinggiBadan(
    modifier: Modifier = Modifier,
    balitaId: Int
){
    val dataBalita = remember { mutableStateListOf<DataBalita?>() }
    LaunchedEffect(Unit) {
        val dataB = fetchDataBaliatById(balitaId)
        if (dataB != null) {
            dataBalita.addAll(dataB)
        }
    }
    var i = 1f
    var b = 0
    val max = dataBalita.maxByOrNull { it!!.height }

    val listDataTinggi: List<Point> = if(dataBalita.isNotEmpty()){
        dataBalita.map {
            Point(i++, dataBalita[b++]?.height?.toFloat() ?: 1f)
        }
    }else {
        DataTinggi
    }
    val steps = max?.height?: 1
    val xAxisData = AxisData.Builder()
        .axisStepSize(100.dp)
        .backgroundColor(MaterialTheme.colorScheme.background)
        .steps(listDataTinggi.size - 1)
        .labelData { i -> i.toString() }
        .labelAndAxisLinePadding(15.dp)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(steps)
        .backgroundColor(MaterialTheme.colorScheme.background)
        .labelAndAxisLinePadding(20.dp)
        .labelData { i ->
            val yScale = 100 / steps
            (i * yScale).toString()
        }.build()

    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = listDataTinggi,
                    LineStyle(),
                    IntersectionPoint(),
                    SelectionHighlightPoint(),
                    ShadowUnderLine(),
                    SelectionHighlightPopUp()
                )
            ),
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(),
        backgroundColor = Color.White
    )
    val sizze = steps*10
    LineChart(
        modifier = modifier
            .fillMaxWidth()
            .height(if (steps>30) sizze.dp else 300.dp),
        lineChartData = lineChartData
    )
}

@Preview(showBackground = true)
@Composable
private fun PrevieTryChartline(){
    PekaTheme {
        TinggiBadan(balitaId = 1)
    }
}