package org.csystem.samples.application.generic.randomgenerator

import org.csystem.samples.application.generic.annotation.provider.AuthRandom
import java.lang.Appendable
import javax.inject.Inject
import kotlin.random.Random

class RandomGenerator @Inject constructor(@AuthRandom private val mRandom: Random) {
    //...
    fun generateRandomNumber(min:Int, max: Int) = mRandom.nextInt(min, max)
}