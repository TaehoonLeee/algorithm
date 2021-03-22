
fun main(args : Array<String>) {
    val flag_rules = arrayOf("-s STRINGS", "-n NUMBERS", "-e NULL")
    val cli = CLI("trip", flag_rules)
    print(cli.testCommand("line -n 100 102 -s hi -e".split(" ")))
}


/*
 * 프로그램의 커맨드에 대한 정보와 커맨드의 유효성을 검사하는 클래스.
 * @constructor 프로그램과 옵션의 규칙들을 생성자 인자로 받아 인스턴스를 생성.
 */
class CLI(_program : String, flag_rules : Array<String>) {

    private val program = _program

    init {
        flag_rules.forEach {
            val flag_rule = it.split(" ")
            addRules(flag_rule[0], flag_rule[1])
        }
    }

    /*
     * @param [rule], [argument] 인자로 받은 rule과 그에 해당하는 인자를 클래스의 rules에 추가.
     */
    fun addRules(rule : String, argument : String) {
        RULES.rules.put(rule, argument)
    }

    /*
     * @param [command] 인자로 받은 커맨드의 유효성을 검사하는 함수.
     * object ARGUMENTS의 필드에 따라 유효성을 검사한다.
     */
    fun testCommand(command : List<String>)  : Boolean{
        var ret = true
        if(command[0] != program) ret = false

        var index = 1
        while(index != command.size-1) {
            if(isRule(command[index])) {
                val rule = RULES.rules.get(command[index])
                val arguments = mutableListOf<String>()
                while(index+1 < command.size && !isRule(command[++index])) {
                    arguments.add(command[index])
                }

                when(rule) {
                    ARGUMENTS.NULL -> if( !ARGUMENTS.isNull(arguments) ) ret = false
                    ARGUMENTS.NUMBER -> if( !ARGUMENTS.isNumber(arguments) ) ret = false
                    ARGUMENTS.STRING -> if( !ARGUMENTS.isString(arguments) ) ret = false
                    ARGUMENTS.STRINGS -> if( !ARGUMENTS.isStrings(arguments) ) ret = false
                    ARGUMENTS.NUMBERS -> if( !ARGUMENTS.isNumbers(arguments) ) ret = false
                    else -> ret = false
                }
            }
            else index++
        }

        return ret
    }

    private fun isRule(string: String): Boolean {
        return string[0] == '-'
    }

    object ARGUMENTS {
        const val NULL = "NULL"
        const val STRING = "STRING"
        const val NUMBER = "NUMBER"
        const val STRINGS = "STRINGS"
        const val NUMBERS = "NUMBERS"

        fun isString(arguments : List<String>) : Boolean {
            val pattern = Regex("[a-zA-Z_]+")

            return arguments.size == 1 && pattern.matches(arguments[0])
        }

        fun isNumber(arguments: List<String>) : Boolean {
            val pattern = Regex("[0-9]+")

            return arguments.size == 1 && pattern.matches(arguments[0])
        }

        fun isStrings(arguments : List<String>) : Boolean {
            val pattern = Regex("[a-zA-Z_]+")
            var ret = true
            arguments.forEach {
               if(!pattern.matches(it)) ret = false
            }

            return ret
        }

        fun isNull(arguments: List<String>): Boolean {
            return arguments.isNullOrEmpty()
        }

        fun isNumbers(arguments: List<String>): Boolean {
            val pattern = Regex("[0-9]+")
            var ret = true
            arguments.forEach {
                if(!pattern.matches(it)) ret = false
            }

            return ret
        }
    }

    object RULES {
        val rules : MutableMap<String, String> = HashMap()
    }
}

fun prob1() {
    val table = arrayOf("SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA")
    val language = arrayOf("JAVA", "JAVASCRIPT")
    val preference = arrayOf(7, 5)

    var score = 0
    var answer =""
    table.forEachIndexed { _, job ->
        val scoreTable = job.split(" ")

        var tmpScore = 0
        scoreTable.forEachIndexed { tableIndex, tableLanguage ->
            language.forEachIndexed { languageIndex, language ->
                if(language == tableLanguage) {
                    tmpScore += preference[languageIndex] * (6 - tableIndex)
                }
            }
        }

        answer = if(score < tmpScore) {
            score = tmpScore
            scoreTable[0]
        } else if (score == tmpScore) {
            if(answer > scoreTable[0]) scoreTable[0] else answer
        } else {
            answer
        }
    }

    print(answer)
}