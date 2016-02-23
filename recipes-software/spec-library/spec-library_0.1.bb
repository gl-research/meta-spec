SUMMARY = "Provides libspec dynamic library intended for user-space SPEC control"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PR = "r0"
PV = "0.1"


SRC_URI = "git://ohwr.org/fmc-projects/spec/spec-sw.git \
           file://makefile-fix.patch \
           file://makefile-tools.patch \
           file://makefile-fmc-tools.patch \
           file://makefile-fmc-tools-ipmi.patch \
           file://makefile-fmc-fix.patch"
SRCREV = "d56cd47c9ba68630b907488288c57e251eb5c2d3"

S = "${WORKDIR}/git"

export CROSS_COMPILE_SYSROOT = "${STAGING_DIR_TARGET}"

# Most of spec-sw is in git submodules that still need to be fetched.

do_fetch_extra(){
    git submodule update --init --recursive
}
addtask fetch_extra after do_unpack before do_patch


FILES_SOLIBSDEV = ""
FILES_${PN} += "${libdir}/*.so"

do_install() {
             install -d ${D}${libdir}
             install -m 0755 ${S}/tools/libspec.so ${D}${libdir}
}



# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
