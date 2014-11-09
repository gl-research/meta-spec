SUMMARY = "Full spec-sw support, including user-space tools and spec,fmc,wr-nic kernel modules"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PR = "r0"
PV = "0.1"


SRC_URI = "git://ohwr.org/fmc-projects/spec/spec-sw.git \
           file://makefile-fix.patch \
           file://makefile-fmc-fix.patch"
SRCREV = "eb9b9d03e3f54657fe29fca93021e2b45380da05"

S = "${WORKDIR}/git"


# Most of spec-sw is in git submodules that still need to be fetched.

do_fetch_extra(){
    git submodule update --init --recursive
}
addtask fetch_extra after do_unpack before do_patch


FILES_${PN} += "${bindir}/*"
FILES_${PN}-staticdev = "${bindir}/libspec.a"

do_install_extra() {
             install -d ${D}${bindir}
             install -m 0755 ${S}/tools/spec-cl ${D}${bindir}
             install -m 0755 ${S}/tools/spec-fwloader ${D}${bindir}
             install -m 0755 ${S}/tools/spec-vuart ${D}${bindir}
             install -m 0755 ${S}/tools/specmem ${D}${bindir}
             install -m 0755 ${S}/tools/wr-dio-cmd ${D}${bindir}
             install -m 0755 ${S}/tools/wr-dio-pps ${D}${bindir}
             install -m 0755 ${S}/tools/wr-dio-agent ${D}${bindir}
             install -m 0755 ${S}/tools/wr-dio-ruler ${D}${bindir}
             install -m 0755 ${S}/tools/stamp-frame ${D}${bindir}
             install -m 0755 ${S}/binaries/fmc-dio-eeprom.bin ${D}${bindir}
}
addtask install_extra after do_install before do_populate_sysroot



# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
