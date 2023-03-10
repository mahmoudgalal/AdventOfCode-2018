package com.mgalal.general.aoc2018

import kotlin.math.abs
import kotlin.math.min

class AdventOfCodeDay10 {
    private val allPointsString: String by lazy {
        "position=<-50948,  20587> velocity=< 5, -2>\n" +
                "position=< 20732, -51094> velocity=<-2,  5>\n" +
                "position=<-30471, -10131> velocity=< 3,  1>\n" +
                "position=<-40758,  10355> velocity=< 4, -1>\n" +
                "position=< 30912,  20590> velocity=<-3, -2>\n" +
                "position=< 30927,  30827> velocity=<-3, -3>\n" +
                "position=<-20237,  20591> velocity=< 2, -2>\n" +
                "position=< 51423, -51086> velocity=<-5,  5>\n" +
                "position=<-40732, -20370> velocity=< 4,  2>\n" +
                "position=<-20271, -51094> velocity=< 2,  5>\n" +
                "position=<-40764, -30605> velocity=< 4,  3>\n" +
                "position=<-30492,  41073> velocity=< 3, -4>\n" +
                "position=<-30473, -30614> velocity=< 3,  3>\n" +
                "position=<-51004,  41074> velocity=< 5, -4>\n" +
                "position=<-30481,  30829> velocity=< 3, -3>\n" +
                "position=<-50961, -10130> velocity=< 5,  1>\n" +
                "position=<-50968,  51306> velocity=< 5, -5>\n" +
                "position=<-30489, -40850> velocity=< 3,  4>\n" +
                "position=<-20273,  51307> velocity=< 2, -5>\n" +
                "position=<-40732,  10351> velocity=< 4, -1>\n" +
                "position=<-40764, -30612> velocity=< 4,  3>\n" +
                "position=< 10483,  51307> velocity=<-1, -5>\n" +
                "position=<-30511, -30614> velocity=< 3,  3>\n" +
                "position=< 20719, -40848> velocity=<-2,  4>\n" +
                "position=<-20249, -10129> velocity=< 2,  1>\n" +
                "position=< 30919, -51090> velocity=<-3,  5>\n" +
                "position=<-20281,  20595> velocity=< 2, -2>\n" +
                "position=< 30931,  30830> velocity=<-3, -3>\n" +
                "position=<-20240,  41071> velocity=< 2, -4>\n" +
                "position=< -9988, -51087> velocity=< 1,  5>\n" +
                "position=<-50991,  51315> velocity=< 5, -5>\n" +
                "position=<-10022,  30826> velocity=< 1, -3>\n" +
                "position=<-20241,  30830> velocity=< 2, -3>\n" +
                "position=< 10492, -30610> velocity=<-1,  3>\n" +
                "position=<-30525,  51313> velocity=< 3, -5>\n" +
                "position=< 10492, -20370> velocity=<-1,  2>\n" +
                "position=< 10492, -20371> velocity=<-1,  2>\n" +
                "position=<-20255,  30830> velocity=< 2, -3>\n" +
                "position=< 51403,  20595> velocity=<-5, -2>\n" +
                "position=< 10489, -20370> velocity=<-1,  2>\n" +
                "position=< 10492,  41067> velocity=<-1, -4>\n" +
                "position=< 20722, -40854> velocity=<-2,  4>\n" +
                "position=< 10451,  30830> velocity=<-1, -3>\n" +
                "position=< 10452, -10125> velocity=<-1,  1>\n" +
                "position=< 41151,  51306> velocity=<-4, -5>\n" +
                "position=< 51410, -30610> velocity=<-5,  3>\n" +
                "position=<-20289, -51093> velocity=< 2,  5>\n" +
                "position=<-40708,  30828> velocity=< 4, -3>\n" +
                "position=<-20244, -40851> velocity=< 2,  4>\n" +
                "position=<-20257, -30612> velocity=< 2,  3>\n" +
                "position=< 30943, -10131> velocity=<-3,  1>\n" +
                "position=<-40718,  10346> velocity=< 4, -1>\n" +
                "position=<-40769, -51091> velocity=< 4,  5>\n" +
                "position=< 30967,  41074> velocity=<-3, -4>\n" +
                "position=<-40728, -30614> velocity=< 4,  3>\n" +
                "position=<-40711,  20589> velocity=< 4, -2>\n" +
                "position=< 10487, -51090> velocity=<-1,  5>\n" +
                "position=< 10459,  20595> velocity=<-1, -2>\n" +
                "position=<-10025,  10346> velocity=< 1, -1>\n" +
                "position=< 30913,  41066> velocity=<-3, -4>\n" +
                "position=< 51407,  20595> velocity=<-5, -2>\n" +
                "position=< 30911, -10134> velocity=<-3,  1>\n" +
                "position=<-40769,  51310> velocity=< 4, -5>\n" +
                "position=<-10001, -51085> velocity=< 1,  5>\n" +
                "position=<-10004,  20594> velocity=< 1, -2>\n" +
                "position=<-20281, -40849> velocity=< 2,  4>\n" +
                "position=< 51444, -20365> velocity=<-5,  2>\n" +
                "position=<-40769,  20593> velocity=< 4, -2>\n" +
                "position=< 41183,  20588> velocity=<-4, -2>\n" +
                "position=< 30932,  51315> velocity=<-3, -5>\n" +
                "position=< 41192, -10130> velocity=<-4,  1>\n" +
                "position=< 10488,  41068> velocity=<-1, -4>\n" +
                "position=<-10022, -20370> velocity=< 1,  2>\n" +
                "position=< 30954,  30831> velocity=<-3, -3>\n" +
                "position=<-30513, -40845> velocity=< 3,  4>\n" +
                "position=< 51428,  30831> velocity=<-5, -3>\n" +
                "position=<-40760, -40845> velocity=< 4,  4>\n" +
                "position=<-10009,  30832> velocity=< 1, -3>\n" +
                "position=< 41151,  20586> velocity=<-4, -2>\n" +
                "position=< 30972,  30831> velocity=<-3, -3>\n" +
                "position=< 20675, -30607> velocity=<-2,  3>\n" +
                "position=< 51436, -30606> velocity=<-5,  3>\n" +
                "position=<-50977, -40852> velocity=< 5,  4>\n" +
                "position=< 10471, -40847> velocity=<-1,  4>\n" +
                "position=< 10463,  20590> velocity=<-1, -2>\n" +
                "position=< 30911, -10129> velocity=<-3,  1>\n" +
                "position=< 10476,  41074> velocity=<-1, -4>\n" +
                "position=< 51423,  51309> velocity=<-5, -5>\n" +
                "position=<-50948, -20367> velocity=< 5,  2>\n" +
                "position=< 51419,  30835> velocity=<-5, -3>\n" +
                "position=< 10474,  51306> velocity=<-1, -5>\n" +
                "position=< 10431,  51308> velocity=<-1, -5>\n" +
                "position=<-40733,  41074> velocity=< 4, -4>\n" +
                "position=< 30915,  51306> velocity=<-3, -5>\n" +
                "position=< 30959,  10354> velocity=<-3, -1>\n" +
                "position=< 30972,  20595> velocity=<-3, -2>\n" +
                "position=< 30913, -30610> velocity=<-3,  3>\n" +
                "position=<-10041, -20368> velocity=< 1,  2>\n" +
                "position=<-50972, -20368> velocity=< 5,  2>\n" +
                "position=<-30476,  30828> velocity=< 3, -3>\n" +
                "position=< 41196, -40851> velocity=<-4,  4>\n" +
                "position=<-40753, -20374> velocity=< 4,  2>\n" +
                "position=< 30927, -20368> velocity=<-3,  2>\n" +
                "position=<-20271, -10130> velocity=< 2,  1>\n" +
                "position=<-10046, -40850> velocity=< 1,  4>\n" +
                "position=<-20244,  51308> velocity=< 2, -5>\n" +
                "position=<-20280,  30835> velocity=< 2, -3>\n" +
                "position=< 51391, -30610> velocity=<-5,  3>\n" +
                "position=< 20724, -20365> velocity=<-2,  2>\n" +
                "position=<-40710,  10352> velocity=< 4, -1>\n" +
                "position=<-20289,  41075> velocity=< 2, -4>\n" +
                "position=< 20690, -51085> velocity=<-2,  5>\n" +
                "position=<-40729,  30834> velocity=< 4, -3>\n" +
                "position=< 51428,  51313> velocity=<-5, -5>\n" +
                "position=< -9998, -10129> velocity=< 1,  1>\n" +
                "position=< 20728, -30612> velocity=<-2,  3>\n" +
                "position=< 51447,  41075> velocity=<-5, -4>\n" +
                "position=< 41159, -30605> velocity=<-4,  3>\n" +
                "position=<-40744, -20374> velocity=< 4,  2>\n" +
                "position=< 41188, -51085> velocity=<-4,  5>\n" +
                "position=< 30943, -10126> velocity=<-3,  1>\n" +
                "position=<-10006, -10134> velocity=< 1,  1>\n" +
                "position=< 51399, -10131> velocity=<-5,  1>\n" +
                "position=< 41204,  30834> velocity=<-4, -3>\n" +
                "position=< 30914, -40850> velocity=<-3,  4>\n" +
                "position=< 30948, -51093> velocity=<-3,  5>\n" +
                "position=<-30486,  30826> velocity=< 3, -3>\n" +
                "position=< 10439,  10346> velocity=<-1, -1>\n" +
                "position=< 20721, -51089> velocity=<-2,  5>\n" +
                "position=<-50956, -10130> velocity=< 5,  1>\n" +
                "position=< 10464, -30613> velocity=<-1,  3>\n" +
                "position=< 10492, -30608> velocity=<-1,  3>\n" +
                "position=<-10031,  10346> velocity=< 1, -1>\n" +
                "position=< 30953,  30830> velocity=<-3, -3>\n" +
                "position=< 41204,  51308> velocity=<-4, -5>\n" +
                "position=< 20695, -10127> velocity=<-2,  1>\n" +
                "position=<-40709, -10126> velocity=< 4,  1>\n" +
                "position=<-30497, -20369> velocity=< 3,  2>\n" +
                "position=< 51396,  10354> velocity=<-5, -1>\n" +
                "position=< 20698,  41075> velocity=<-2, -4>\n" +
                "position=<-20286, -51089> velocity=< 2,  5>\n" +
                "position=< 30955,  41066> velocity=<-3, -4>\n" +
                "position=<-10046,  30830> velocity=< 1, -3>\n" +
                "position=<-20254,  10352> velocity=< 2, -1>\n" +
                "position=< -9993, -51094> velocity=< 1,  5>\n" +
                "position=<-50967, -40850> velocity=< 5,  4>\n" +
                "position=<-40753, -51088> velocity=< 4,  5>\n" +
                "position=<-20272,  30835> velocity=< 2, -3>\n" +
                "position=< 10475,  51313> velocity=<-1, -5>\n" +
                "position=<-40769, -40851> velocity=< 4,  4>\n" +
                "position=< 51447, -10128> velocity=<-5,  1>\n" +
                "position=<-10036,  20595> velocity=< 1, -2>\n" +
                "position=< 51431, -40852> velocity=<-5,  4>\n" +
                "position=< 41204, -10127> velocity=<-4,  1>\n" +
                "position=< 51448,  51307> velocity=<-5, -5>\n" +
                "position=<-51008, -51094> velocity=< 5,  5>\n" +
                "position=< 20727, -20369> velocity=<-2,  2>\n" +
                "position=<-50969,  41075> velocity=< 5, -4>\n" +
                "position=< 20707,  10353> velocity=<-2, -1>\n" +
                "position=< 51447, -10130> velocity=<-5,  1>\n" +
                "position=< 10439,  20588> velocity=<-1, -2>\n" +
                "position=< 10490, -20368> velocity=<-1,  2>\n" +
                "position=<-40769,  41068> velocity=< 4, -4>\n" +
                "position=< 30915, -51090> velocity=<-3,  5>\n" +
                "position=<-20273,  30831> velocity=< 2, -3>\n" +
                "position=< 10463,  20586> velocity=<-1, -2>\n" +
                "position=< 51417,  41075> velocity=<-5, -4>\n" +
                "position=<-50948,  41071> velocity=< 5, -4>\n" +
                "position=<-30470,  20591> velocity=< 3, -2>\n" +
                "position=< 51439,  51311> velocity=<-5, -5>\n" +
                "position=< 51399,  51307> velocity=<-5, -5>\n" +
                "position=<-30478, -40849> velocity=< 3,  4>\n" +
                "position=<-40727,  41070> velocity=< 4, -4>\n" +
                "position=<-30503,  51306> velocity=< 3, -5>\n" +
                "position=<-20252,  51308> velocity=< 2, -5>\n" +
                "position=<-20265, -51094> velocity=< 2,  5>\n" +
                "position=<-30468, -40846> velocity=< 3,  4>\n" +
                "position=<-30501, -30611> velocity=< 3,  3>\n" +
                "position=<-20263, -40849> velocity=< 2,  4>\n" +
                "position=< 20714,  20591> velocity=<-2, -2>\n" +
                "position=<-20252, -40854> velocity=< 2,  4>\n" +
                "position=<-40729, -40853> velocity=< 4,  4>\n" +
                "position=<-10047,  30826> velocity=< 1, -3>\n" +
                "position=< 10479, -51088> velocity=<-1,  5>\n" +
                "position=< 51443,  41071> velocity=<-5, -4>\n" +
                "position=<-50969, -40854> velocity=< 5,  4>\n" +
                "position=<-40742, -20374> velocity=< 4,  2>\n" +
                "position=< 41155,  20592> velocity=<-4, -2>\n" +
                "position=< 41175,  41074> velocity=<-4, -4>\n" +
                "position=< 20679,  20594> velocity=<-2, -2>\n" +
                "position=<-20265,  10355> velocity=< 2, -1>\n" +
                "position=< 41184,  20587> velocity=<-4, -2>\n" +
                "position=< 41177, -40845> velocity=<-4,  4>\n" +
                "position=< 30938, -20374> velocity=<-3,  2>\n" +
                "position=< 20732,  30830> velocity=<-2, -3>\n" +
                "position=<-20273,  51314> velocity=< 2, -5>\n" +
                "position=< 41178,  51310> velocity=<-4, -5>\n" +
                "position=< 20687,  30829> velocity=<-2, -3>\n" +
                "position=<-50964,  10347> velocity=< 5, -1>\n" +
                "position=< 51391, -51093> velocity=<-5,  5>\n" +
                "position=<-30485, -51088> velocity=< 3,  5>\n" +
                "position=<-30468, -30611> velocity=< 3,  3>\n" +
                "position=<-30513,  51312> velocity=< 3, -5>\n" +
                "position=<-40753,  10347> velocity=< 4, -1>\n" +
                "position=<-50993,  51308> velocity=< 5, -5>\n" +
                "position=< 41194, -51089> velocity=<-4,  5>\n" +
                "position=< 30919, -30607> velocity=<-3,  3>\n" +
                "position=< 51436,  51315> velocity=<-5, -5>\n" +
                "position=<-20245, -20368> velocity=< 2,  2>\n" +
                "position=< 30913, -20370> velocity=<-3,  2>\n" +
                "position=< 30943, -51086> velocity=<-3,  5>\n" +
                "position=<-20273,  41073> velocity=< 2, -4>\n" +
                "position=< 10484, -40850> velocity=<-1,  4>\n" +
                "position=< 10492, -40848> velocity=<-1,  4>\n" +
                "position=<-10009,  30826> velocity=< 1, -3>\n" +
                "position=< 20679, -20368> velocity=<-2,  2>\n" +
                "position=<-50959, -30614> velocity=< 5,  3>\n" +
                "position=<-40741, -10134> velocity=< 4,  1>\n" +
                "position=< 30919,  30834> velocity=<-3, -3>\n" +
                "position=<-10033,  30833> velocity=< 1, -3>\n" +
                "position=<-30489,  30831> velocity=< 3, -3>\n" +
                "position=<-30492, -40848> velocity=< 3,  4>\n" +
                "position=<-40720, -30613> velocity=< 4,  3>\n" +
                "position=<-50993, -30612> velocity=< 5,  3>\n" +
                "position=<-40745, -20365> velocity=< 4,  2>\n" +
                "position=<-10024, -20368> velocity=< 1,  2>\n" +
                "position=< 41152,  30830> velocity=<-4, -3>\n" +
                "position=< 30951,  20586> velocity=<-3, -2>\n" +
                "position=<-40740,  41075> velocity=< 4, -4>\n" +
                "position=< 51416, -40845> velocity=<-5,  4>\n" +
                "position=<-30527, -51090> velocity=< 3,  5>\n" +
                "position=< 41161,  51315> velocity=<-4, -5>\n" +
                "position=<-40764, -20365> velocity=< 4,  2>\n" +
                "position=< 51448, -51093> velocity=<-5,  5>\n" +
                "position=<-30521,  10349> velocity=< 3, -1>\n" +
                "position=<-20249,  51312> velocity=< 2, -5>\n" +
                "position=<-30513,  10354> velocity=< 3, -1>\n" +
                "position=< 30945,  30830> velocity=<-3, -3>\n" +
                "position=< -9996,  30832> velocity=< 1, -3>\n" +
                "position=< 10468, -51085> velocity=<-1,  5>\n" +
                "position=<-30487,  10346> velocity=< 3, -1>\n" +
                "position=< 51391,  10352> velocity=<-5, -1>\n" +
                "position=< 10471,  41067> velocity=<-1, -4>\n" +
                "position=<-10033,  30830> velocity=< 1, -3>\n" +
                "position=< 30932,  30835> velocity=<-3, -3>\n" +
                "position=< 41199,  51308> velocity=<-4, -5>\n" +
                "position=<-40713, -10134> velocity=< 4,  1>\n" +
                "position=<-10005, -51088> velocity=< 1,  5>\n" +
                "position=< 10475, -20370> velocity=<-1,  2>\n" +
                "position=< 10484,  41071> velocity=<-1, -4>\n" +
                "position=< 10439, -20367> velocity=<-1,  2>\n" +
                "position=< 10448, -51090> velocity=<-1,  5>\n" +
                "position=<-30529,  20591> velocity=< 3, -2>\n" +
                "position=< 41188,  41068> velocity=<-4, -4>\n" +
                "position=< 51419,  10349> velocity=<-5, -1>\n" +
                "position=<-20289,  10348> velocity=< 2, -1>\n" +
                "position=<-20265, -10134> velocity=< 2,  1>\n" +
                "position=< 30927,  30831> velocity=<-3, -3>\n" +
                "position=< 41183, -40849> velocity=<-4,  4>\n" +
                "position=< 10487, -10128> velocity=<-1,  1>\n" +
                "position=<-20236, -51086> velocity=< 2,  5>\n" +
                "position=< 30943, -20371> velocity=<-3,  2>\n" +
                "position=< 30948,  20589> velocity=<-3, -2>\n" +
                "position=<-10015, -30611> velocity=< 1,  3>\n" +
                "position=< 41208, -20372> velocity=<-4,  2>\n" +
                "position=< 51431, -20372> velocity=<-5,  2>\n" +
                "position=<-10016,  41068> velocity=< 1, -4>\n" +
                "position=< 41180, -40852> velocity=<-4,  4>\n" +
                "position=<-20230, -10129> velocity=< 2,  1>\n" +
                "position=<-40713, -51092> velocity=< 4,  5>\n" +
                "position=<-40712,  41067> velocity=< 4, -4>\n" +
                "position=< 51418,  20595> velocity=<-5, -2>\n" +
                "position=< 41191,  30827> velocity=<-4, -3>\n" +
                "position=<-20233, -10133> velocity=< 2,  1>\n" +
                "position=< 51395,  10352> velocity=<-5, -1>\n" +
                "position=< 41212, -30609> velocity=<-4,  3>\n" +
                "position=< 41167, -51086> velocity=<-4,  5>\n" +
                "position=<-40737,  20595> velocity=< 4, -2>\n" +
                "position=<-10040, -10125> velocity=< 1,  1>\n" +
                "position=<-40753, -10129> velocity=< 4,  1>\n" +
                "position=< 30927,  51310> velocity=<-3, -5>\n" +
                "position=< 20676,  20589> velocity=<-2, -2>\n" +
                "position=<-30529, -10128> velocity=< 3,  1>\n" +
                "position=< 20729,  51310> velocity=<-2, -5>\n" +
                "position=<-20229, -40847> velocity=< 2,  4>\n" +
                "position=< 41196,  20587> velocity=<-4, -2>\n" +
                "position=< 10468,  51314> velocity=<-1, -5>\n" +
                "position=< 20676,  41067> velocity=<-2, -4>\n" +
                "position=< -9993,  30834> velocity=< 1, -3>\n" +
                "position=<-51004,  51307> velocity=< 5, -5>\n" +
                "position=< 51410,  30835> velocity=<-5, -3>\n" +
                "position=<-30476,  41075> velocity=< 3, -4>\n" +
                "position=<-20281,  20590> velocity=< 2, -2>\n" +
                "position=< 20727, -40852> velocity=<-2,  4>\n" +
                "position=<-10001, -30609> velocity=< 1,  3>\n" +
                "position=< 20691,  30826> velocity=<-2, -3>\n" +
                "position=<-51001,  20587> velocity=< 5, -2>\n" +
                "position=<-51001,  51310> velocity=< 5, -5>\n" +
                "position=<-20252, -30612> velocity=< 2,  3>\n" +
                "position=<-20257, -30610> velocity=< 2,  3>\n" +
                "position=< 20703, -20370> velocity=<-2,  2>\n" +
                "position=< 41207, -51093> velocity=<-4,  5>\n" +
                "position=<-30481,  20593> velocity=< 3, -2>\n" +
                "position=<-30510, -30614> velocity=< 3,  3>\n" +
                "position=<-10001, -20366> velocity=< 1,  2>\n" +
                "position=<-30485,  20590> velocity=< 3, -2>\n" +
                "position=< 10460, -51094> velocity=<-1,  5>\n" +
                "position=< 51410, -40850> velocity=<-5,  4>\n" +
                "position=<-20236,  20589> velocity=< 2, -2>\n" +
                "position=<-20241,  20594> velocity=< 2, -2>\n" +
                "position=<-10044, -10132> velocity=< 1,  1>\n" +
                "position=<-10048,  20586> velocity=< 1, -2>\n" +
                "position=<-20245, -10130> velocity=< 2,  1>\n" +
                "position=< 30951, -10131> velocity=<-3,  1>\n" +
                "position=< -9993, -40852> velocity=< 1,  4>\n" +
                "position=< 30971, -30607> velocity=<-3,  3>\n" +
                "position=< 51391,  20594> velocity=<-5, -2>\n" +
                "position=<-50951, -51091> velocity=< 5,  5>\n" +
                "position=< -9993,  20593> velocity=< 1, -2>\n" +
                "position=< 10480, -10129> velocity=<-1,  1>\n" +
                "position=< 41211,  51314> velocity=<-4, -5>\n" +
                "position=< 30912, -10134> velocity=<-3,  1>\n" +
                "position=< 30944,  30828> velocity=<-3, -3>\n" +
                "position=< 30915, -51090> velocity=<-3,  5>\n" +
                "position=< -9999,  10351> velocity=< 1, -1>\n" +
                "position=< 51395,  51312> velocity=<-5, -5>\n" +
                "position=<-40729,  20588> velocity=< 4, -2>\n" +
                "position=<-20229, -40846> velocity=< 2,  4>\n" +
                "position=<-10033,  30833> velocity=< 1, -3>\n" +
                "position=< 41168,  41066> velocity=<-4, -4>\n" +
                "position=< 20703,  51306> velocity=<-2, -5>\n" +
                "position=< 20732,  51309> velocity=<-2, -5>\n" +
                "position=<-10020,  10347> velocity=< 1, -1>\n" +
                "position=<-40716, -10130> velocity=< 4,  1>\n" +
                "position=< 41212,  10352> velocity=<-4, -1>\n" +
                "position=< 10464, -51093> velocity=<-1,  5>\n" +
                "position=< 10434,  41066> velocity=<-1, -4>\n" +
                "position=< 10451,  51315> velocity=<-1, -5>\n" +
                "position=<-40764, -10133> velocity=< 4,  1>\n" +
                "position=<-10049, -10126> velocity=< 1,  1>\n" +
                "position=< 10463,  10347> velocity=<-1, -1>\n" +
                "position=< 20732,  41075> velocity=<-2, -4>\n" +
                "position=<-30488, -10130> velocity=< 3,  1>\n" +
                "position=<-10009,  10349> velocity=< 1, -1>\n" +
                "position=<-40744, -10134> velocity=< 4,  1>\n" +
                "position=< 20703,  41073> velocity=<-2, -4>\n" +
                "position=< 41204, -51092> velocity=<-4,  5>\n" +
                "position=<-50960, -51093> velocity=< 5,  5>\n" +
                "position=<-40748,  20586> velocity=< 4, -2>\n" +
                "position=< 51428,  20591> velocity=<-5, -2>\n" +
                "position=<-30489,  30831> velocity=< 3, -3>\n" +
                "position=< 10472,  10350> velocity=<-1, -1>\n" +
                "position=< 41199, -20371> velocity=<-4,  2>\n" +
                "position=<-30489,  41069> velocity=< 3, -4>\n" +
                "position=<-20241,  10352> velocity=< 2, -1>\n" +
                "position=< 41188, -51090> velocity=<-4,  5>\n" +
                "position=<-10004, -40845> velocity=< 1,  4>\n" +
                "position=<-30497, -51088> velocity=< 3,  5>\n" +
                "position=< 30943,  20591> velocity=<-3, -2>\n" +
                "position=<-50956, -10129> velocity=< 5,  1>\n" +
                "position=< 41186, -20369> velocity=<-4,  2>\n" +
                "position=< 30948,  41066> velocity=<-3, -4>\n" +
                "position=< 30919,  51309> velocity=<-3, -5>\n" +
                "position=< 10451,  10355> velocity=<-1, -1>\n" +
                "position=< 10475,  20586> velocity=<-1, -2>\n" +
                "position=< 30959,  20588> velocity=<-3, -2>\n" +
                "position=< 41187, -51087> velocity=<-4,  5>\n" +
                "position=< 30956,  51309> velocity=<-3, -5>\n" +
                "position=<-30497,  41075> velocity=< 3, -4>\n" +
                "position=< 51396,  51309> velocity=<-5, -5>\n" +
                "position=< 30962, -51094> velocity=<-3,  5>\n" +
                "position=< 30967, -51091> velocity=<-3,  5>\n" +
                "position=< 10487,  20587> velocity=<-1, -2>\n" +
                "position=<-40732,  30826> velocity=< 4, -3>\n" +
                "position=<-50985,  10354> velocity=< 5, -1>\n" +
                "position=<-40753, -40850> velocity=< 4,  4>\n" +
                "position=< 10476, -51092> velocity=<-1,  5>\n" +
                "position=<-50966,  10350> velocity=< 5, -1>\n" +
                "position=< 30930,  51306> velocity=<-3, -5>"
    }

    private var allProcessed: List<Pose>

    data class Pose(
        val position: Pair<Int, Int>,
        val velocity: Pair<Int, Int>,
    )

    init {
        allProcessed = allPointsString.split("position=", " velocity=")
            .filterNot {
                it.trim().isEmpty()
            }
            .flatMap {
                it.trim().replace("<", "").replace(">", "")
                    .split(",")
            }.map {
                it.trim().toInt()
            }
            .windowed(4, 4)
            .map {
                Pose(
                    position = Pair(it[0], it[1]),
                    velocity = Pair(it[2], it[3])
                )
            }
        println(allProcessed)
        println("Size of Data ${allProcessed.size}")
    }

    fun runSimulation() {
        // The solution assumes that the hidden message will occur only when there is a high alignment
        // of the points making the message along the X & Y axis. Here we are computing the maximum acheived
        // Alignment score for x & y at each time-step of the simulation. The biggest value is recorded along
        // with the time step when it happened .
        var alignmentScoreX = Int.MAX_VALUE
        var alignmentScoreY = Int.MAX_VALUE
        var totalAlignmentScore = Int.MAX_VALUE
        var maxTimeStep = 0
        for (i: Int in 1..NO_OF_ITERATIONS) {
            val timeStepped = allProcessed.map {
                it.copy(
                    position = Pair(
                        it.position.first + (it.velocity.first * i),
                        it.position.second + (it.velocity.second * i)
                    )
                )
            }
            val allAlignedX = timeStepped.groupBy {
                abs(it.position.first)
            }
            val allAlignedY = timeStepped.groupBy {
                abs(it.position.second)
            }
            alignmentScoreX = min(allAlignedX.keys.size, alignmentScoreX)
            alignmentScoreY = min(allAlignedY.keys.size, alignmentScoreY)
            val currentTotalAlignmentScore = alignmentScoreX + alignmentScoreY
            if (currentTotalAlignmentScore < totalAlignmentScore) {
                totalAlignmentScore = currentTotalAlignmentScore
                maxTimeStep = i
            }
        }
        println("Result:")
        println("Found max alignment score = $totalAlignmentScore ,at maxTimeStep = $maxTimeStep")
        //Print X Coordinates for plotting
        val allX = allProcessed.map {
            it.copy(
                position = Pair(
                    it.position.first + (it.velocity.first * maxTimeStep),
                    it.position.second + (it.velocity.second * maxTimeStep)
                )
            )
        }.map {
            it.position.first
        }
        //Print Y Coordinates for plotting
        val allY = allProcessed.map {
            it.copy(
                position = Pair(
                    it.position.first + (it.velocity.first * maxTimeStep),
                    it.position.second + (it.velocity.second * maxTimeStep)
                )
            )
        }.map {
            it.position.second
        }
        val maxX = (allX.maxOrNull()?:0)
        val maxY = (allY.maxOrNull()?:0)
        val display:StringBuilder = StringBuilder(" ".repeat(maxX)+"\n")
        repeat(maxY){
            display.append(" ".repeat(maxX)+"\n")
        }
        allX.forEachIndexed { index, i ->
            display[i+ (maxX*allY[index])]='#'
        }
        println(allX)
        println(allY)
        println(display)
    }
    companion object{
        const val NO_OF_ITERATIONS = 15000
    }
}

fun main(){
    val adventOfCodeDay10 = AdventOfCodeDay10()
    adventOfCodeDay10.runSimulation()
    // Expected Message = RLEZNRAN
    // Expected Time Step = 10240
}