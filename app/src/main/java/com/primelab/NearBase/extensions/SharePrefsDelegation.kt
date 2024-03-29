package com.primelab.NearBase.extensions

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


fun SharedPreferences.string(
    key: (KProperty<*>) -> String = KProperty<*>::name,
    defaultValue: String = ""
): ReadWriteProperty<Any, String> = object : ReadWriteProperty<Any, String> {
    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) =
        edit().putString(key(property), value).apply()
    override fun getValue(thisRef: Any, property: KProperty<*>): String =
        getString(key(property), defaultValue)!!
}
fun SharedPreferences.stringNullable(
    key: (KProperty<*>) -> String = KProperty<*>::name,
    defaultValue: String? = null
): ReadWriteProperty<Any, String?> = object : ReadWriteProperty<Any, String?> {
    override fun setValue(thisRef: Any, property: KProperty<*>, value: String?) =
        edit().putString(key(property), value).apply()
    override fun getValue(thisRef: Any, property: KProperty<*>): String? =
        getString(key(property), defaultValue)
}
fun SharedPreferences.int(
    key: (KProperty<*>) -> String = KProperty<*>::name,
    defaultValue: Int = -1
): ReadWriteProperty<Any, Int> = object : ReadWriteProperty<Any, Int> {
    override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) =
        edit().putInt(key(property), value).apply()
    override fun getValue(thisRef: Any, property: KProperty<*>): Int =
        getInt(key(property), defaultValue)
}
fun SharedPreferences.long(
    key: (KProperty<*>) -> String = KProperty<*>::name,
    defaultValue: Long = -1
): ReadWriteProperty<Any, Long> = object : ReadWriteProperty<Any, Long> {
    override fun setValue(thisRef: Any, property: KProperty<*>, value: Long) =
        edit().putLong(key(property), value).apply()
    override fun getValue(thisRef: Any, property: KProperty<*>): Long =
        getLong(key(property), defaultValue)
}
fun SharedPreferences.boolean(
    key: (KProperty<*>) -> String = KProperty<*>::name,
    defaultValue: Boolean = false
): ReadWriteProperty<Any, Boolean> = object : ReadWriteProperty<Any, Boolean> {
    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) =
        edit().putBoolean(key(property), value).apply()
    override fun getValue(thisRef: Any, property: KProperty<*>): Boolean =
        getBoolean(key(property), defaultValue)
}