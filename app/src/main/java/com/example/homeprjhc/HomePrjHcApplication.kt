package com.example.homeprjhc

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

abstract class  BasePrjHcApplication : Application()

@HiltAndroidApp
class HomePrjHcApplication : BasePrjHcApplication()