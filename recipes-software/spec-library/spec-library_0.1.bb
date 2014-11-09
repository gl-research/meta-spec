SUMMARY = "Provides libspec dynamic library intended for user-space SPEC control"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PR = "r0"
PV = "0.1"


SRC_URI = "git://ohwr.org/fmc-projects/spec/spec-sw.git \
           file://makefile-fix.patch"
SRCREV = "aed186b9a3783b1f3763eb0ba64613d536250b9d"

S = "${WORKDIR}/git"


FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/*.so"

do_install() {
             install -d ${D}${libdir}
             install -m 0755 ${S}/tools/libspec.so ${D}${libdir}
}



# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
