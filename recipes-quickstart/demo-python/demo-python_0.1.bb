SUMMARY = "Python files for running the demos included in the Getting Started with the SPEC"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

inherit module

PR = "r0"
PV = "0.1"


SRC_URI = "git://ohwr.org/fmc-projects/spec/spec-getting-started.git"
SRCREV = "2997988af51f4a10f318cf0056ef284266c47bd5"

S = "${WORKDIR}/git"



FILES_${PN} += "/lib/firmware/fmc/python"


do_compile() {
    :
}

do_install() {
             install -d ${D}/lib/firmware/fmc/python
             install -m 0755 ${S}/sw/python/spec_demo_user.py ${D}/lib/firmware/fmc/python/spec_demo_user.py
             install -m 0755 ${S}/sw/python/spec_demo_user_dio.py ${D}/lib/firmware/fmc/python/spec_demo_user_dio.py
             install -m 0755 ${S}/sw/python/spec_libc.py ${D}/lib/firmware/fmc/python/spec_libc.py
}


# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
