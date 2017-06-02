package com.example

import com.google.auto.service.AutoService
import java.io.IOException
import javax.annotation.processing.AbstractProcessor

import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement
import javax.tools.StandardLocation

@AutoService(Processor::class)
class MyProcessor : AbstractProcessor() {
    override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        // Done during :app:compileDebugJavaWithJavac
        try {
            processingEnv.filer.createResource(StandardLocation.SOURCE_OUTPUT,
                    "com.example.kotlingeneratingprocessor.extension", "Extension.kt").openWriter().use {
                it.write("package com.example.kotlingeneratingprocessor.extension\n\n")
                it.write("import com.example.kotlingeneratingprocessor.MainActivity\n\n")
                it.write("fun MainActivity.getGenString() = \"Generated Text\"\n")
                it.flush()
            }
        } catch (ignored: IOException) { // Exception ignored : attempt to reopen a file for path
        }
        return true
    }

    override fun getSupportedSourceVersion() : SourceVersion = SourceVersion.latestSupported()

    override fun getSupportedAnnotationTypes() = setOf("com.example.kotlingeneratingprocessor.MyAnnotation")
}
